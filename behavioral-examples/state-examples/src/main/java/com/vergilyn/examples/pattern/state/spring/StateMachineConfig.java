package com.vergilyn.examples.pattern.state.spring;

import java.util.EnumSet;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.config.EnableStateMachine;
import org.springframework.statemachine.config.EnumStateMachineConfigurerAdapter;
import org.springframework.statemachine.config.builders.StateMachineConfigurationConfigurer;
import org.springframework.statemachine.config.builders.StateMachineStateConfigurer;
import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer;
import org.springframework.statemachine.listener.StateMachineListener;
import org.springframework.statemachine.listener.StateMachineListenerAdapter;
import org.springframework.statemachine.transition.Transition;

// 创建状态机配置类
@Slf4j
@Configuration
// `@EnableStateMachine`注解用来启用Spring StateMachine状态机功能
@EnableStateMachine
public class StateMachineConfig extends EnumStateMachineConfigurerAdapter<StateEnum, EventEnum> {

	/* 用来初始化当前状态机拥有哪些状态，
	 * 其中`initial(States.UNPAID)`定义了初始状态为UNPAID，
	 * `states(EnumSet.allOf(States.class))`则指定了使用上一步中定义的所有状态作为该状态机的状态定义。
	 */
	@Override
	public void configure(StateMachineStateConfigurer<StateEnum, EventEnum> states) throws Exception {
		states.withStates()
				.initial(StateEnum.UNPAID)
				.states(EnumSet.allOf(StateEnum.class));
	}

	/* 用来初始化当前状态机有哪些状态迁移动作，
	 * 其中命名中我们很容易理解每一个迁移动作，都有来源状态source，目标状态target以及触发事件event。
	 */
	@Override
	public void configure(StateMachineTransitionConfigurer<StateEnum, EventEnum> transitions) throws Exception {
		transitions
				.withExternal().source(StateEnum.UNPAID).target(StateEnum.WAITING_FOR_RECEIVE).event(EventEnum.PAY)
				.and()
				.withExternal().source(StateEnum.WAITING_FOR_RECEIVE).target(StateEnum.DONE).event(EventEnum.RECEIVE);

	}

	/* 为当前的状态机指定了状态监听器，
	 * 其中`listener()`则是调用了下一个内容创建的监听器实例，用来处理各个各个发生的状态迁移事件。
	 */
	@Override
	public void configure(StateMachineConfigurationConfigurer<StateEnum, EventEnum> config) throws Exception {
		config.withConfiguration().listener(listener());
	}

	@Bean
	public StateMachineListener<StateEnum, EventEnum> listener() {
		return new StateMachineListenerAdapter<StateEnum, EventEnum>() {

			@Override
			public void transition(Transition<StateEnum, EventEnum> transition) {
				if (transition.getTarget().getId() == StateEnum.UNPAID) {
					log.info("订单创建，待支付");
					return;
				}

				if (transition.getSource().getId() == StateEnum.UNPAID
						&& transition.getTarget().getId() == StateEnum.WAITING_FOR_RECEIVE) {
					log.info("用户完成支付，待收货");
					return;
				}

				if (transition.getSource().getId() == StateEnum.WAITING_FOR_RECEIVE
						&& transition.getTarget().getId() == StateEnum.DONE) {
					log.info("用户已收货，订单完成");
					return;
				}
			}

		};
	}

}
