package org.sheepy.lily.vulkan.api.process;

import org.logoce.extender.api.IAdapter;
import org.sheepy.lily.vulkan.api.concurrent.IFenceView;

public interface IProcessAdapter extends IAdapter
{
	IFenceView run();

	void waitIdle();

	// Can fire the fence listeners (for TransferBuffer Fetch).
	// TODO really sad that the client needs to call that...
	void checkFences();

	boolean isMultithreadAllowed();
}
