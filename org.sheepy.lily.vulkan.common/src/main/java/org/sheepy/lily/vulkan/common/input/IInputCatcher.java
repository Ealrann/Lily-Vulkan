package org.sheepy.vulkan.common.input;

import java.util.List;

import org.sheepy.common.api.input.IInputManager.IInputListener;
import org.sheepy.common.api.input.event.IInputEvent;

public interface IInputCatcher extends IInputListener
{
	void startCatch();
	boolean hasCaughtInputs(List<IInputEvent> events);
}
