package org.sheepy.lily.vulkan.demo.mesh;

import org.sheepy.lily.core.model.application.IEngine;
import org.sheepy.lily.core.model.cadence.Cadence;
import org.sheepy.lily.core.model.cadence.CadenceFactory;
import org.sheepy.lily.vulkan.model.VulkanEngine;
import org.sheepy.lily.vulkan.model.VulkanFactory;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicFactory;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicProcess;
import org.sheepy.vulkan.model.enumeration.EAttachmentLoadOp;
import org.sheepy.vulkan.model.enumeration.EAttachmentStoreOp;
import org.sheepy.vulkan.model.enumeration.EImageLayout;
import org.sheepy.vulkan.model.enumeration.ESampleCount;

public final class MeshEngineFactory
{
	public static IEngine build()
	{
		final VulkanEngine engine = VulkanFactory.eINSTANCE.createVulkanEngine();

		final var framebufferConfiguration = GraphicFactory.eINSTANCE.createFramebufferConfiguration();
		final var graphicConfiguration = GraphicFactory.eINSTANCE.createGraphicConfiguration();
		final var swapchainConfiguration = GraphicFactory.eINSTANCE.createSwapchainConfiguration();
		swapchainConfiguration.setAcquireWaitForVBlank(false);
		swapchainConfiguration.setPresentWhenVBlank(false);

		graphicConfiguration.setSwapchainConfiguration(swapchainConfiguration);
		graphicConfiguration.setFramebufferConfiguration(framebufferConfiguration);
		graphicConfiguration.setColorDomain(GraphicFactory.eINSTANCE.createColorDomain());

		final var graphicProcess = GraphicFactory.eINSTANCE.createGraphicProcess();
		graphicProcess.setResetAllowed(true);
		graphicProcess.setConfiguration(graphicConfiguration);
		graphicProcess.setCadence(buildCadence(graphicProcess));

		final var colorAttachmentDescriptor = GraphicFactory.eINSTANCE.createSwapImageAttachment();
		colorAttachmentDescriptor.setSamples(ESampleCount.SAMPLE_COUNT_1BIT);
		colorAttachmentDescriptor.setLoadOp(EAttachmentLoadOp.CLEAR);
		colorAttachmentDescriptor.setStoreOp(EAttachmentStoreOp.STORE);
		colorAttachmentDescriptor.setStencilLoadOp(EAttachmentLoadOp.DONT_CARE);
		colorAttachmentDescriptor.setStencilStoreOp(EAttachmentStoreOp.DONT_CARE);
		colorAttachmentDescriptor.setInitialLayout(EImageLayout.UNDEFINED);
		colorAttachmentDescriptor.setFinalLayout(EImageLayout.PRESENT_SRC_KHR);

		final var renderPass = GraphicFactory.eINSTANCE.createRenderPassInfo();
		graphicProcess.setRenderPassInfo(renderPass);
		renderPass.setColorAttachment(colorAttachmentDescriptor);

		engine.getProcesses().add(graphicProcess);

		return engine;
	}

	private static final Cadence buildCadence(GraphicProcess graphicProcess)
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
