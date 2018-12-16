package org.sheepy.vulkan.common.input;

import org.sheepy.common.api.input.IInputManager.IInputListener;

public interface IInputCatcher extends IInputListener
{
	void startCatch();
	boolean hasCaughtInputs();
}
