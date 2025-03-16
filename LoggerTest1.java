// Logger 接口
interface Logger {
    void log(String message);
}

// 文件日志记录器
class FileLogger implements Logger {
    @Override
    public void log(String message) {
        System.out.println("Logging to file: " + message);
    }
}

// 数据库日志记录器
class DatabaseLogger implements Logger {
    @Override
    public void log(String message) {
        System.out.println("Logging to database: " + message);
    }
}

// 抽象工厂类
abstract class LoggerFactory {
    public abstract Logger createLogger();

    // 可选：提供一个通用的日志记录方法
    public void logMessage(String message) {
        Logger logger = createLogger();
        logger.log(message);
    }
}

// 文件日志工厂
class FileLoggerFactory extends LoggerFactory {
    @Override
    public Logger createLogger() {
        return new FileLogger();
    }
}

// 数据库日志工厂
class DatabaseLoggerFactory extends LoggerFactory {
    @Override
    public Logger createLogger() {
        return new DatabaseLogger();
    }
}

// 测试类
public class LoggerTest1 {
    public static void main(String[] args) {
        // 使用文件日志
        LoggerFactory fileFactory = new FileLoggerFactory();
        fileFactory.logMessage("This is a file log test.");

        // 使用数据库日志
        LoggerFactory dbFactory = new DatabaseLoggerFactory();
        dbFactory.logMessage("This is a database log test.");
    }
}