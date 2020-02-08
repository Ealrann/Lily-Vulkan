package org.sheepy.lily.openal.api.model;

import org.eclipse.emf.ecore.EPackage;
import org.sheepy.lily.core.api.resource.IModelExtension;
import org.sheepy.lily.openal.model.openal.OpenalPackage;

import java.util.Collection;
import java.util.List;

public class OpenALModelExtension implements IModelExtension
{
	@Override
	public Collection<EPackage> getEPackages()
	{
		return List.of(OpenalPackage.eINSTANCE);
	}
}
