package org.sheepy.lily.vulkan.extra.graphic;

import org.logoce.extender.api.IAdapter;
import org.logoce.extender.api.IAdapterProvider;
import org.sheepy.lily.vulkan.extra.graphic.rendering.GenericRendererMaintainerAdapter;
import org.sheepy.lily.vulkan.extra.graphic.rendering.RenderPipelineAllocator;
import org.sheepy.lily.vulkan.extra.graphic.rendering.buffer.RenderProxyConstantBufferAdapter;
import org.sheepy.lily.vulkan.extra.graphic.rendering.camera.CameraAdapter;
import org.sheepy.lily.vulkan.extra.graphic.rendering.camera.CameraMatrixVariableAdapter;
import org.sheepy.lily.vulkan.extra.graphic.rendering.camera.CameraPositionVariableAdapter;
import org.sheepy.lily.vulkan.extra.graphic.rendering.camera.CameraScreenWorldPositionVariableAdapter;
import org.sheepy.lily.vulkan.extra.graphic.rendering.mousepick.MousePickDataConsumer;
import org.sheepy.lily.vulkan.extra.graphic.rendering.mousepick.MousePickExtensionAdapter;
import org.sheepy.lily.vulkan.extra.graphic.rendering.resource.DataDescriptorsProviderAdapter;
import org.sheepy.lily.vulkan.extra.graphic.rendering.resource.DescriptorProviderAdapter;
import org.sheepy.lily.vulkan.extra.graphic.sprite.*;

import java.lang.invoke.MethodHandles;
import java.util.List;

public final class Extenders implements IAdapterProvider
{
	@Override
	public List<Class<? extends IAdapter>> classifiers()
	{
		return List.of(GenericRendererMaintainerAdapter.class,
					   CameraAdapter.class,
					   CameraMatrixVariableAdapter.class,
					   CameraPositionVariableAdapter.class,
					   CameraScreenWorldPositionVariableAdapter.class,
					   DescriptorProviderAdapter.class,
					   RenderProxyConstantBufferAdapter.class,
					   DataDescriptorsProviderAdapter.class,
					   RenderPipelineAllocator.class,
					   MousePickDataConsumer.class,
					   MousePickExtensionAdapter.class,
					   SpriteIndexConfigurator.class,
					   SpriteSpecializationFiller.class,
					   SpriteResourceInstaller.class,
					   SpriteDataSourceConfigurator.class,
					   SpritePipelineActivator.class,
					   SpriteIndexSupplier.class);
	}

	@Override
	public MethodHandles.Lookup lookup()
	{
		return MethodHandles.lookup();
	}
}
