package org.sheepy.lily.vulkan.extra.api.nuklear;

import org.logoce.lmf.core.api.extender.IAdapter;
import org.logoce.lmf.core.lang.LMObject;
import org.sheepy.lily.core.model.ui.IControl;

import java.util.List;

public interface IControlProviderAdapter extends IAdapter
{
	List<IControl> buildControls(LMObject input);
}
