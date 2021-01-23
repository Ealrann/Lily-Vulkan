package org.sheepy.lily.vulkan.process.graphic.process;

import org.sheepy.lily.core.api.allocation.EAllocationStatus;
import org.sheepy.lily.core.api.allocation.IAllocationState;
import org.sheepy.lily.core.api.allocation.annotation.Allocation;
import org.sheepy.lily.core.api.allocation.annotation.AllocationChild;
import org.sheepy.lily.core.api.allocation.annotation.Free;
import org.logoce.extender.api.IAdapter;
import org.logoce.extender.api.ModelExtender;
import org.sheepy.lily.vulkan.core.execution.RecordContext;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicConfiguration;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicProcess;
import org.sheepy.lily.vulkan.process.process.ProcessContext;

import java.util.function.Consumer;

@ModelExtender(scope = GraphicConfiguration.class)
@Allocation(context = ProcessContext.class)
@AllocationChild(features = GraphicPackage.GRAPHIC_CONFIGURATION__SURFACE)
@AllocationChild(features = GraphicPackage.GRAPHIC_CONFIGURATION__SWAPCHAIN_CONFIGURATION)
@AllocationChild(features = GraphicPackage.GRAPHIC_CONFIGURATION__RENDER_PASS)
@AllocationChild(features = GraphicPackage.GRAPHIC_CONFIGURATION__IMAGE_VIEWS)
@AllocationChild(features = GraphicPackage.GRAPHIC_CONFIGURATION__FRAMEBUFFER_CONFIGURATION)
public final class GraphicConfigurationAllocation implements IAdapter
{
	private final GraphicConfiguration configuration;
	private final IAllocationState allocationState;
	private final Consumer<EAllocationStatus> statusChange;

	private GraphicConfigurationAllocation(final GraphicConfiguration configuration,
										   final IAllocationState allocationState)
	{
		this.configuration = configuration;
		this.allocationState = allocationState;
		statusChange = this::statusChange;
		allocationState.listenStatus(statusChange);
	}

	@Free
	private void free()
	{
		allocationState.sulkStatus(statusChange);
	}

	private void statusChange(final EAllocationStatus status)
	{
		if (status != EAllocationStatus.Allocated)
		{
			final var process = (GraphicProcess) configuration.eContainer();
			final var processAllocation = process.adapt(GraphicProcessAllocation.class);

			// The previous configuration must be deallocated before reallocating a new one
			processAllocation.waitIdle();

			assert allocationState.isLocked() == false;
		}
	}

	public void attach(final RecordContext context)
	{
		context.lockAllocationDuringExecution(allocationState);
	}
}
