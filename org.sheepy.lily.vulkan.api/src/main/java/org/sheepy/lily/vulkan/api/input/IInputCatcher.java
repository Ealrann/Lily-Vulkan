package org.sheepy.lily.vulkan.api.input;

import org.sheepy.lily.core.api.input.event.InputEvent;

import java.util.List;

public interface IInputCatcher
{
	void update(final List<InputEvent<?>> events);

	boolean hasCaughtInputs();
	boolean isCursorThere();
}
