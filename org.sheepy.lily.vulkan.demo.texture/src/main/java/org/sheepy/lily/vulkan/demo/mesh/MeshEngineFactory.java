package org.sheepy.lily.vulkan.demo.mesh;

import org.joml.Vector4f;
import org.sheepy.lily.core.model.application.IEngine;
import org.sheepy.lily.core.model.cadence.Cadence;
import org.sheepy.lily.core.model.cadence.PrintUPS;
import org.sheepy.lily.vulkan.model.process.graphic.AttachmentPkg;
import org.sheepy.lily.vulkan.model.process.graphic.ColorDomain;
import org.sheepy.lily.vulkan.model.process.graphic.DepthAttachment;
import org.sheepy.lily.vulkan.model.process.graphic.FramebufferConfiguration;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicConfiguration;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicExecutionManager;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicProcess;
import org.sheepy.lily.vulkan.model.process.graphic.ImageViews;
import org.sheepy.lily.vulkan.model.process.graphic.PhysicalSurface;
import org.sheepy.lily.vulkan.model.process.graphic.RenderPass;
import org.sheepy.lily.vulkan.model.process.graphic.SwapImageAttachment;
import org.sheepy.lily.vulkan.model.process.graphic.SwapchainConfiguration;
import org.sheepy.lily.vulkan.model.vulkan.RunProcess;
import org.sheepy.lily.vulkan.model.vulkan.VulkanEngine;
import org.sheepy.vulkan.model.enumeration.EAttachmentLoadOp;
import org.sheepy.vulkan.model.enumeration.EAttachmentStoreOp;
import org.sheepy.vulkan.model.enumeration.EImageLayout;
import org.sheepy.vulkan.model.enumeration.EImageUsage;
import org.sheepy.vulkan.model.enumeration.ESampleCount;

public final class MeshEngineFactory
{
	public static IEngine build()
	{
		final var colorAttachmentDescriptor = SwapImageAttachment.builder()
																 .samples(ESampleCount.SAMPLE_COUNT_1_BIT)
																 .loadOp(EAttachmentLoadOp.CLEAR)
																 .storeOp(EAttachmentStoreOp.STORE)
																 .stencilLoadOp(EAttachmentLoadOp.DONT_CARE)
																 .stencilStoreOp(EAttachmentStoreOp.DONT_CARE)
																 .initialLayout(EImageLayout.UNDEFINED)
																 .finalLayout(EImageLayout.PRESENT_SRC_KHR)
																 .clearValue(new Vector4f(0f, 0f, 0f, 0f))
																 .build();

		final var swapchainConfiguration = SwapchainConfiguration.builder()
																 .acquireWaitForVBlank(false)
																 .presentWhenVBlank(false)
																 .colorAttachment(() -> colorAttachmentDescriptor)
																 .build();

		final var graphicConfiguration = GraphicConfiguration.builder()
															 .surface(() -> PhysicalSurface.builder()
																						   .colorDomain(ColorDomain.builder()::build)
																						   .build())
															 .swapchainConfiguration(() -> swapchainConfiguration)
															 .framebufferConfiguration(FramebufferConfiguration.builder()::build)
															 .imageViews(ImageViews.builder()::build)
															 .renderPass(RenderPass.builder()::build)
															 .build();

		final var depthAttachment = DepthAttachment.builder()
												   .samples(ESampleCount.SAMPLE_COUNT_1_BIT)
												   .loadOp(EAttachmentLoadOp.CLEAR)
												   .storeOp(EAttachmentStoreOp.DONT_CARE)
												   .stencilLoadOp(EAttachmentLoadOp.DONT_CARE)
												   .stencilStoreOp(EAttachmentStoreOp.DONT_CARE)
												   .initialLayout(EImageLayout.UNDEFINED)
												   .finalLayout(EImageLayout.DEPTH_STENCIL_ATTACHMENT_OPTIMAL)
												   .addUsage(EImageUsage.DEPTH_STENCIL_ATTACHMENT)
												   .build();

		final var graphicProcess = GraphicProcess.builder()
												.executionManager(GraphicExecutionManager.builder()::build)
												.resetAllowed(true)
												.configuration(() -> graphicConfiguration)
												.attachmentPkg(() -> AttachmentPkg.builder()
																				  .addExtraAttachment(() -> depthAttachment)
																				  .build())
												.build();

		graphicProcess.cadence(buildCadence(graphicProcess));

		return VulkanEngine.builder()
						  .addProcesse(() -> graphicProcess)
						  .build();
	}

	private static Cadence buildCadence(GraphicProcess graphicProcess)
	{
		final var runGraphicTask = RunProcess.builder()
											 .process(() -> graphicProcess)
											 .build();

		return Cadence.builder()
					  .frequency(60)
					  .addTask(() -> runGraphicTask)
					  .addTask(() -> PrintUPS.builder().printEveryMs(1200).build())
					  .build();
	}
}
