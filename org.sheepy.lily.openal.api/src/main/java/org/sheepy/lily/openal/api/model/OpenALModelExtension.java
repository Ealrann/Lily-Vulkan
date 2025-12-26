package org.sheepy.lily.openal.api.model;

import org.logoce.lmf.core.api.model.IModelPackage;
import org.sheepy.lily.core.api.resource.IModelExtension;
import org.sheepy.lily.openal.model.openal.OpenALModelPackage;

import java.util.Collection;
import java.util.List;

public class OpenALModelExtension implements IModelExtension
{
	@Override
	public Collection<IModelPackage> getEPackages()
	{
		return List.of(OpenALModelPackage.Instance);
	}
}
