package org.sheepy.lily.vulkan.api.resource;

import org.sheepy.lily.core.api.adapter.IAdapter;
import org.sheepy.lily.core.model.application.IResource;
import org.sheepy.lily.core.model.application.ResourcePkg;
import org.sheepy.lily.vulkan.model.resource.FileImage;
import org.sheepy.lily.vulkan.model.resource.StaticImage;
import org.sheepy.vulkan.model.image.ImageInfo;
import org.sheepy.vulkan.model.image.ImageLayout;

public interface IVulkanResource_Deployer extends IAdapter
{
	IResource getVulkanResource();

	boolean isDeployed();
	
	StaticImage deployImageFromInfo(ResourcePkg pkg, ImageInfo info, ImageLayout layout);
	FileImage deployImageFromFile(ResourcePkg pkg, ImageLayout layout, boolean mipmap);
}
