// Logger 接口（不变）
interface Logger {
    void log(String message);
}

// 文件日志记录器（不变）
class FileLogger implements Logger {
    @Override
    public void log(String message) {
        System.out.println("Logging to file: " + message);
    }
}

// 数据库日志记录器（不变）
class DatabaseLogger implements Logger {
    @Override
    public void log(String message) {
        System.out.println("Logging to database: " + message);
    }
}

// 新增：控制台日志记录器
class ConsoleLogger implements Logger {
    @Override
    public void log(String message) {
        System.out.println("Logging to console: " + message);
    }
}

// 抽象工厂类（不变）
abstract class LoggerFactory {
    public abstract Logger createLogger();

    public void logMessage(String message) {
        Logger logger = createLogger();
        logger.log(message);
    }
}

// 文件日志工厂（不变）
class FileLoggerFactory extends LoggerFactory {
    @Override
    public Logger createLogger() {
        return new FileLogger();
    }
}

// 数据库日志工厂（不变）
class DatabaseLoggerFactory extends LoggerFactory {
    @Override
    public Logger createLogger() {
        return new DatabaseLogger();
    }
}

// 新增：控制台日志工厂
class ConsoleLoggerFactory extends LoggerFactory {
    @Override
    public Logger createLogger() {
        return new ConsoleLogger();
    }
}

// 测试类（扩展测试）
public class LoggerTest2 {
    public static void main(String[] args) {
        // 使用文件日志
        LoggerFactory fileFactory = new FileLoggerFactory();
        fileFactory.logMessage("This is a file log test.");

        // 使用数据库日志
        LoggerFactory dbFactory = new DatabaseLoggerFactory();
        dbFactory.logMessage("This is a database log test.");

        // 使用控制台日志
        LoggerFactory consoleFactory = new ConsoleLoggerFactory();
        consoleFactory.logMessage("This is a console log test.");
    }
}