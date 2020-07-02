package org.sheepy.lily.vulkan.api.process;

import org.sheepy.lily.core.api.extender.IExtender;
import org.sheepy.lily.vulkan.api.concurrent.IFenceView;

public interface IProcessAdapter extends IExtender
{
	IFenceView run();

	void waitIdle();

	// Can fire the fence listeners (for TransferBuffer Fetch).
	// TODO really sad that the client needs to call that...
	void checkFence();

	boolean isMultithreadAllowed();
}
