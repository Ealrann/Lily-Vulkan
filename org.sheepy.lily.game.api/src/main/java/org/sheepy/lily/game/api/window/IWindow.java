package org.sheepy.lily.game.api.window;

public interface IWindow
{
	boolean isOpenned();
	long getPtr();
	void addListener(IWindowListener listener);
	void removeListener(IWindowListener listener);
	void hideCursor(boolean hide);
	int getRefreshRate();
}
