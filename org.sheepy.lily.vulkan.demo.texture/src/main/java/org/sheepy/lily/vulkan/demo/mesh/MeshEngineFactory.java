package org.sheepy.lily.vulkan.demo.mesh;

import org.sheepy.lily.core.model.application.IEngine;
import org.sheepy.lily.core.model.cadence.Cadence;
import org.sheepy.lily.core.model.cadence.CadenceFactory;
import org.sheepy.lily.vulkan.model.VulkanEngine;
import org.sheepy.lily.vulkan.model.VulkanFactory;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicFactory;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicProcess;
import org.sheepy.vulkan.model.enumeration.*;

public final class MeshEngineFactory
{
	public static IEngine build()
	{
		final VulkanEngine engine = VulkanFactory.eINSTANCE.createVulkanEngine();

		final var colorAttachmentDescriptor = GraphicFactory.eINSTANCE.createSwapImageAttachment();
		colorAttachmentDescriptor.setSamples(ESampleCount.SAMPLE_COUNT_1BIT);
		colorAttachmentDescriptor.setLoadOp(EAttachmentLoadOp.CLEAR);
		colorAttachmentDescriptor.setStoreOp(EAttachmentStoreOp.STORE);
		colorAttachmentDescriptor.setStencilLoadOp(EAttachmentLoadOp.DONT_CARE);
		colorAttachmentDescriptor.setStencilStoreOp(EAttachmentStoreOp.DONT_CARE);
		colorAttachmentDescriptor.setInitialLayout(EImageLayout.UNDEFINED);
		colorAttachmentDescriptor.setFinalLayout(EImageLayout.PRESENT_SRC_KHR);

		final var surface = GraphicFactory.eINSTANCE.createPhysicalSurface();
		final var framebufferConfiguration = GraphicFactory.eINSTANCE.createFramebufferConfiguration();
		final var graphicConfiguration = GraphicFactory.eINSTANCE.createGraphicConfiguration();
		final var swapchainConfiguration = GraphicFactory.eINSTANCE.createSwapchainConfiguration();
		final var imageViews = GraphicFactory.eINSTANCE.createImageViews();
		final var renderPass = GraphicFactory.eINSTANCE.createRenderPass();
		swapchainConfiguration.setAcquireWaitForVBlank(false);
		swapchainConfiguration.setPresentWhenVBlank(false);
		swapchainConfiguration.setColorAttachment(colorAttachmentDescriptor);

		surface.setColorDomain(GraphicFactory.eINSTANCE.createColorDomain());

		graphicConfiguration.setSurface(surface);
		graphicConfiguration.setSwapchainConfiguration(swapchainConfiguration);
		graphicConfiguration.setFramebufferConfiguration(framebufferConfiguration);
		graphicConfiguration.setImageViews(imageViews);
		graphicConfiguration.setRenderPass(renderPass);

		final var graphicProcess = GraphicFactory.eINSTANCE.createGraphicProcess();
		graphicProcess.setExecutionManager(GraphicFactory.eINSTANCE.createGraphicExecutionManager());
		graphicProcess.setResetAllowed(true);
		graphicProcess.setConfiguration(graphicConfiguration);
		graphicProcess.setCadence(buildCadence(graphicProcess));

		final var depthAttachment = GraphicFactory.eINSTANCE.createDepthAttachment();

		depthAttachment.setSamples(ESampleCount.SAMPLE_COUNT_1BIT);
		depthAttachment.setLoadOp(EAttachmentLoadOp.CLEAR);
		depthAttachment.setStoreOp(EAttachmentStoreOp.DONT_CARE);
		depthAttachment.setStencilLoadOp(EAttachmentLoadOp.DONT_CARE);
		depthAttachment.setStencilStoreOp(EAttachmentStoreOp.DONT_CARE);
		depthAttachment.setInitialLayout(EImageLayout.UNDEFINED);
		depthAttachment.setFinalLayout(EImageLayout.DEPTH_STENCIL_ATTACHMENT_OPTIMAL);
		depthAttachment.getUsages().add(EImageUsage.DEPTH_STENCIL_ATTACHMENT);

		final var attachmentPkg = GraphicFactory.eINSTANCE.createAttachmentPkg();
		graphicProcess.setAttachmentPkg(attachmentPkg);
		attachmentPkg.getExtraAttachments().add(depthAttachment);

		engine.getProcesses().add(graphicProcess);

		return engine;
	}

	private static Cadence buildCadence(GraphicProcess graphicProcess)
	{
		final var runGraphicTask = VulkanFactory.eINSTANCE.createRunProcess();
		final var printUPS = CadenceFactory.eINSTANCE.createPrintUPS();
		final var cadence = CadenceFactory.eINSTANCE.createCadence();

		runGraphicTask.setProcess(graphicProcess);
		printUPS.setPrintEveryMs(1200);
		cadence.setFrequency(60);

		cadence.getTasks().add(runGraphicTask);
		cadence.getTasks().add(printUPS);

		return cadence;
	}
}
