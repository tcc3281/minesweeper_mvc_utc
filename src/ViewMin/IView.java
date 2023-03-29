package ViewMin;

public interface IView {
	public void opened(int x,int y);//mo o x,y
	public void setFlag(int x, int y);//cam co o x,y
	public void unsetFlag(int x, int y);//bo cam co
	public void win();///thong bao win
	public void lose();// thua
}
