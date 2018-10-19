package org.sheepy.vulkan.adapter;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.ecore.EClass;
import org.sheepy.common.api.adapter.ISheepyAdapter;
import org.sheepy.common.api.adapter.impl.SheepyAdapterWrapper;

public class VulkanAdapterWrapper extends SheepyAdapterWrapper
{

	public VulkanAdapterWrapper(Class<? extends ISheepyAdapter> classifier, EClass targetEClass)
	{
		super(classifier, targetEClass);
	}

	@Override
	protected ISheepyAdapter instanciateNew()
	{
		ISheepyAdapter res = null;
		Constructor<? extends ISheepyAdapter> constructor;
		try
		{
			constructor = classifier.getConstructor();
			res = constructor.newInstance();
		} catch (NoSuchMethodException | SecurityException | InstantiationException
				| IllegalAccessException | IllegalArgumentException | InvocationTargetException e)
		{
			e.printStackTrace();
		}
		return res;
	}
}
