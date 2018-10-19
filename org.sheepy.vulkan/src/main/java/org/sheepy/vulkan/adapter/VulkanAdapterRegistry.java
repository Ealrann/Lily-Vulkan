package org.sheepy.vulkan.adapter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcorePackage;
import org.sheepy.common.api.adapter.ISheepyAdapter;
import org.sheepy.common.api.adapter.ISheepyAdapterRegistry;
import org.sheepy.common.api.adapter.ISheepyAdapterWrapper;
import org.sheepy.vulkan.application.LogicalDeviceAdapter;
import org.sheepy.vulkan.application.VulkanApplicationAdapter;
import org.sheepy.vulkan.model.VulkanPackage;
import org.sheepy.vulkan.pipeline.compute.ComputePipelineAdapter;
import org.sheepy.vulkan.pipeline.compute.ComputerAdapter;
import org.sheepy.vulkan.pipeline.graphic.image.ImagePipelineAdapter;
import org.sheepy.vulkan.process.compute.ComputeProcessAdapter;
import org.sheepy.vulkan.process.graphic.GraphicProcessAdapter;
import org.sheepy.vulkan.processpool.ExecutionManagerAdapter;
import org.sheepy.vulkan.processpool.ResourceManagerAdapter;
import org.sheepy.vulkan.processpool.compute.ComputeContextAdapter;
import org.sheepy.vulkan.processpool.compute.ComputeProcessPoolAdapter;
import org.sheepy.vulkan.processpool.graphic.GraphicContextAdapter;
import org.sheepy.vulkan.processpool.graphic.GraphicProcessPoolAdapter;
import org.sheepy.vulkan.resource.buffer.BufferAdapter;
import org.sheepy.vulkan.resource.buffer.PushConstantAdapter;
import org.sheepy.vulkan.resource.descriptor.DescriptorSetAdapter;
import org.sheepy.vulkan.resource.file.FileResourceAdapter;
import org.sheepy.vulkan.resource.file.ModuleResourceAdapter;
import org.sheepy.vulkan.resource.image.DepthImageAdapter;
import org.sheepy.vulkan.resource.shader.ShaderAdapter;
import org.sheepy.vulkan.resource.texture.TextureAdapter;

public class VulkanAdapterRegistry implements ISheepyAdapterRegistry
{
	public static VulkanAdapterRegistry INSTANCE = new VulkanAdapterRegistry();

	private final List<ISheepyAdapterWrapper> adapters = new ArrayList<>();
	private final Map<AdapterTypeKey, ISheepyAdapterWrapper> adapterMap = new HashMap<>();

	private VulkanAdapterRegistry()
	{
		newWrapper(VulkanApplicationAdapter.class, VulkanPackage.Literals.VULKAN_APPLICATION);
		newWrapper(PushConstantAdapter.class, VulkanPackage.Literals.PUSH_CONSTANT);
		newWrapper(GraphicProcessPoolAdapter.class, VulkanPackage.Literals.GRAPHIC_PROCESS_POOL);
		newWrapper(ComputeProcessPoolAdapter.class, VulkanPackage.Literals.COMPUTE_PROCESS_POOL);
		newWrapper(GraphicProcessAdapter.class, VulkanPackage.Literals.GRAPHIC_PROCESS);
		newWrapper(ComputeProcessAdapter.class, VulkanPackage.Literals.COMPUTE_PROCESS);
		newWrapper(ComputePipelineAdapter.class, VulkanPackage.Literals.COMPUTE_PIPELINE);
		newWrapper(ComputerAdapter.class, VulkanPackage.Literals.COMPUTER);
		
		newWrapper(ShaderAdapter.class, VulkanPackage.Literals.SHADER);
		newWrapper(TextureAdapter.class, VulkanPackage.Literals.TEXTURE);
		newWrapper(BufferAdapter.class, VulkanPackage.Literals.BUFFER);
		newWrapper(DepthImageAdapter.class, VulkanPackage.Literals.DEPTH_IMAGE);
		newWrapper(FileResourceAdapter.class, VulkanPackage.Literals.FILE_RESOURCE);
		newWrapper(ModuleResourceAdapter.class, VulkanPackage.Literals.MODULE_RESOURCE);

		newWrapper(ImagePipelineAdapter.class, VulkanPackage.Literals.IMAGE_PIPELINE);
		newWrapper(DescriptorSetAdapter.class, VulkanPackage.Literals.DESCRIPTOR_SET);

		newWrapper(LogicalDeviceAdapter.class, EcorePackage.Literals.EOBJECT);
		newWrapper(ResourceManagerAdapter.class, EcorePackage.Literals.EOBJECT);
		newWrapper(ExecutionManagerAdapter.class, EcorePackage.Literals.EOBJECT);
		newWrapper(GraphicContextAdapter.class, EcorePackage.Literals.EOBJECT);
		newWrapper(ComputeContextAdapter.class, EcorePackage.Literals.EOBJECT);

		// newWrapper(ComputeProcessAdapter.class, VulkanPackage.Literals.COMPUTE_PROCESS);
	}

	private void newWrapper(Class<? extends IVulkanAdapter> classifier, EClass eClass)
	{
		adapters.add(new VulkanAdapterWrapper(classifier, eClass));
	}

	public void addWrapper(ISheepyAdapterWrapper wrapper)
	{
		adapters.add(wrapper);
	}

	@Override
	public Collection<ISheepyAdapterWrapper> getRegisteredAdapters()
	{
		return adapters;
	}

	@Override
	public ISheepyAdapterWrapper getAdapterFor(EObject target, Class<? extends ISheepyAdapter> type)
	{
		final AdapterTypeKey key = new AdapterTypeKey(target, type);
		ISheepyAdapterWrapper res = adapterMap.get(key);

		if (res == null)
		{
			final EClass targetEClass = target.eClass();
			for (final ISheepyAdapterWrapper adapterWrapper : adapters)
			{
				if (adapterWrapper.isAdapterForType(type)
						&& adapterWrapper.isApplicable(targetEClass))
				{
					res = adapterWrapper;
					break;
				}
			}

			adapterMap.put(key, res);
		}

		return res;
	}
}
