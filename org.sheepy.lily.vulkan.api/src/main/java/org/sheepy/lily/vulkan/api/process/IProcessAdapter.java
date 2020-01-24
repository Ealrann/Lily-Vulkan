package org.sheepy.lily.vulkan.api.process;

import org.sheepy.lily.core.api.adapter.IAdapter;
import org.sheepy.lily.vulkan.api.concurrent.IFenceView;

public interface IProcessAdapter extends IAdapter
{
	IFenceView run();

	void waitIdle();

	// Can fire the fence listeners (for TransferBuffer Fetch).
	// TODO really sad that the client need to call that...
	void checkFence();

	boolean isMultithreadAllowed();
}
