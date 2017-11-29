package exception;

public class NotFoundShareException extends Exception {
	@Override
	public String getMessage() {
		return "공유 링크를 찾을 수 없습니다.";
	}
}
