package org.sheepy.vulkan.gameoflife;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.ecore.EClass;
import org.sheepy.common.api.adapter.ISheepyAdapter;
import org.sheepy.common.api.adapter.impl.SheepyAdapterWrapper;
import org.sheepy.vulkan.adapter.VulkanAdapterRegistry;
import org.sheepy.vulkan.gameoflife.compute.BoardBufferAdapter;
import org.sheepy.vulkan.gameoflife.compute.BoardImageAdapter;
import org.sheepy.vulkan.gameoflife.model.GameOfLifePackage;

public class MainGameOfLife
{
	public static final int WIDTH = 800;
	public static final int HEIGHT = 600;

	public static void main(String[] args)
	{
		registerWrappers();

		GameOfLifeApplication app = new GameOfLifeApplication(WIDTH, HEIGHT);

		try
		{
			app.launch();
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	private static void registerWrappers()
	{
		var boardBufferWrapper = new GOLAdapterWrapper(BoardBufferAdapter.class,
				GameOfLifePackage.Literals.BOARD_BUFFER);
		VulkanAdapterRegistry.INSTANCE.addWrapper(boardBufferWrapper);

		var boardImageWrapper = new GOLAdapterWrapper(BoardImageAdapter.class,
				GameOfLifePackage.Literals.BOARD_IMAGE);
		VulkanAdapterRegistry.INSTANCE.addWrapper(boardImageWrapper);
	}

	static class GOLAdapterWrapper extends SheepyAdapterWrapper
	{
		public GOLAdapterWrapper(Class<? extends ISheepyAdapter> classifier, EClass targetEClass)
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
					| IllegalAccessException | IllegalArgumentException
					| InvocationTargetException e)
			{
				e.printStackTrace();
			}
			return res;
		}
	}
}
