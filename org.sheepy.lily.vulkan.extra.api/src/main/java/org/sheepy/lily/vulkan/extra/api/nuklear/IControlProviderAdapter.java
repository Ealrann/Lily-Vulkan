package org.sheepy.lily.vulkan.extra.api.nuklear;

import java.util.List;

import org.sheepy.lily.core.api.adapter.IAdapter;
import org.sheepy.lily.core.api.adapter.LilyEObject;
import org.sheepy.lily.core.model.ui.IControl;

public interface IControlProviderAdapter extends IAdapter
{
	List<IControl> buildControls(LilyEObject input);
}
