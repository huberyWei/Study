package cn.com.david.testBigFile;

public interface ErrorHandler {
	void doHandler(Throwable t);
	public static final ErrorHandler PRINTER = new ErrorHandler() {
		@Override
		public void doHandler(Throwable t) {
			t.printStackTrace();
		}
	};
}
