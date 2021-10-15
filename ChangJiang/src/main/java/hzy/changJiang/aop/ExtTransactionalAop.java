package hzy.changJiang.aop;

import hzy.changJiang.utils.TransactionUtils;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.TransactionStatus;

@Component
@Slf4j
@Aspect
public class ExtTransactionalAop {

    @Autowired
    private TransactionUtils transactionUtils;

    /**
     * 定义了Aop切面拦截我们的方法上（有加上HzyTransactional）
     * @param joinPoint
     * @return
     */
    @Around(value = "@annotation(hzy.changJiang.aop.HzyTransactional)")
    public Object around(ProceedingJoinPoint joinPoint) {
        TransactionStatus begin = null;
        try {
            //目标方法
            log.info(">>>开启事务"); // transactionUtils.begin()
            begin = transactionUtils.begin();
            Object result = joinPoint.proceed();
            log.info(">>>提交事务"); //transactionUtils.commit()
            transactionUtils.commit(begin);
            return result;
        }catch (Throwable throwable) {
            throwable.printStackTrace();
            log.info(">>>回滚事务"); // transactionUtils.rollback();
            if (begin != null) {
                transactionUtils.rollback(begin);
            }
            return "系统错误";
        }
    }

}
