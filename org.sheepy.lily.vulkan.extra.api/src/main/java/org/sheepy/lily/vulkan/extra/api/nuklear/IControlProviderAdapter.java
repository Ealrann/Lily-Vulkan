package org.sheepy.lily.vulkan.extra.api.nuklear;

import java.util.List;

import org.sheepy.lily.core.api.model.LilyEObject;
import org.sheepy.lily.core.api.extender.IExtender;
import org.sheepy.lily.core.model.ui.IControl;

public interface IControlProviderAdapter extends IExtender
{
	List<IControl> buildControls(LilyEObject input);
}
