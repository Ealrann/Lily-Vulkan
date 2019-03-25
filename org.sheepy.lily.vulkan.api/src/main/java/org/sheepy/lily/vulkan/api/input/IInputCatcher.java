package org.sheepy.lily.vulkan.api.input;

import java.util.List;

import org.sheepy.lily.core.api.input.IInputManager.IInputListener;
import org.sheepy.lily.core.api.input.event.IInputEvent;

public interface IInputCatcher extends IInputListener
{
	void startCatch();
	boolean hasCaughtInputs(List<IInputEvent> events);
}
