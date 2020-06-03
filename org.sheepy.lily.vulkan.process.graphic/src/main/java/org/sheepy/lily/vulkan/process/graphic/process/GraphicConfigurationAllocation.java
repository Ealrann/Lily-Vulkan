package org.sheepy.lily.vulkan.process.graphic.process;

import org.sheepy.lily.core.api.allocation.annotation.Allocation;
import org.sheepy.lily.core.api.allocation.annotation.AllocationChild;
import org.sheepy.lily.core.api.allocation.annotation.AllocationDependency;
import org.sheepy.lily.core.api.extender.IExtender;
import org.sheepy.lily.core.api.extender.ModelExtender;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicConfiguration;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage;
import org.sheepy.lily.vulkan.process.graphic.frame.FramebufferAllocation;
import org.sheepy.lily.vulkan.process.graphic.frame.ImageViewAllocation;
import org.sheepy.lily.vulkan.process.graphic.frame.PhysicalSurfaceAllocation;
import org.sheepy.lily.vulkan.process.graphic.frame.SwapChainAllocation;
import org.sheepy.lily.vulkan.process.graphic.renderpass.RenderPassAllocation;
import org.sheepy.lily.vulkan.process.process.ProcessContext;

@ModelExtender(scope = GraphicConfiguration.class)
@Allocation(context = ProcessContext.class)
@AllocationChild(features = GraphicPackage.GRAPHIC_CONFIGURATION__SURFACE)
@AllocationChild(features = GraphicPackage.GRAPHIC_CONFIGURATION__SWAPCHAIN_CONFIGURATION)
@AllocationChild(features = GraphicPackage.GRAPHIC_CONFIGURATION__RENDER_PASS)
@AllocationChild(features = GraphicPackage.GRAPHIC_CONFIGURATION__IMAGE_VIEWS)
@AllocationChild(features = GraphicPackage.GRAPHIC_CONFIGURATION__FRAMEBUFFER_CONFIGURATION)
@AllocationDependency(features = GraphicPackage.GRAPHIC_CONFIGURATION__SURFACE, type = PhysicalSurfaceAllocation.class)
@AllocationDependency(features = GraphicPackage.GRAPHIC_CONFIGURATION__SWAPCHAIN_CONFIGURATION, type = SwapChainAllocation.class)
@AllocationDependency(features = GraphicPackage.GRAPHIC_CONFIGURATION__RENDER_PASS, type = RenderPassAllocation.class)
@AllocationDependency(features = GraphicPackage.GRAPHIC_CONFIGURATION__IMAGE_VIEWS, type = ImageViewAllocation.class)
@AllocationDependency(features = GraphicPackage.GRAPHIC_CONFIGURATION__FRAMEBUFFER_CONFIGURATION, type = FramebufferAllocation.class)
public final class GraphicConfigurationAllocation implements IExtender
{
}
