package co.dearu.live.api.common.exception;


/**
 * 오류
 */
public class CommonException extends Exception {

    public static class DefaultParameterException extends Exception {
        public DefaultParameterException(String message) {
            super(message);
        }
    }

    public static class RdsExecutionException extends Exception{
        public RdsExecutionException(String message){super(message);}
    }

    public static class RedisExecutionException extends Exception{
        public RedisExecutionException(String message){super(message);}
    }

    public static class IotExecutionException extends Exception{
        public IotExecutionException(String message){super(message);}
    }
}
