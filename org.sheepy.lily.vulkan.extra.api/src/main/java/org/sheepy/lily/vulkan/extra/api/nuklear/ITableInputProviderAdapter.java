package org.sheepy.lily.vulkan.extra.api.nuklear;

import java.util.List;

import org.eclipse.emf.ecore.EAttribute;
import org.sheepy.lily.core.api.adapter.IAdapter;
import org.sheepy.lily.core.api.adapter.LilyEObject;

public interface ITableInputProviderAdapter extends IAdapter
{
	List<EAttribute> getFeatures(LilyEObject input);
	
	String getName(EAttribute feature);
}
