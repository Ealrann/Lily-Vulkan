package org.sheepy.lily.vulkan.api.input;

import org.sheepy.lily.core.api.input.IInputManager;

public interface IVulkanInputManager extends IInputManager
{
	void setInputCatcher(IInputCatcher catcher);
}
