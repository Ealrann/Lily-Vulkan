package org.sheepy.lily.vulkan.api.view;

import org.sheepy.lily.core.api.extender.IExtender;
import org.sheepy.lily.core.model.application.ICompositor;
import org.sheepy.lily.vulkan.api.device.IVulkanApiContext;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicProcess;
import org.sheepy.lily.vulkan.model.process.graphic.Subpass;

public interface ICompositor_SubpassProvider<T extends ICompositor> extends IExtender
{
	Subpass build(T part, GraphicProcess process, IVulkanApiContext context);
}
