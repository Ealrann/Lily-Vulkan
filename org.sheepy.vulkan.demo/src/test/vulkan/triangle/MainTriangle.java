package test.vulkan.triangle;

import org.sheepy.vulkan.VulkanApplicationLauncher;
import org.sheepy.vulkan.model.VulkanApplication;

import test.vulkan.common.VulkanDemoWrapperUtil;
import test.vulkan.mesh.MeshConfiguration;
import test.vulkan.mesh.MeshModelFactory;

public class MainTriangle
{
	private static final int WIDTH = 800;
	private static final int HEIGHT = 600;
	
	private VulkanApplication application;

	public static void main(String[] args)
	{
		final MainTriangle mainTriangle = new MainTriangle();
		mainTriangle.launch();
	}

	public MainTriangle()
	{
		final var meshBuilder = new TriangleMeshBuilder();
		VulkanDemoWrapperUtil.registerWrappers(meshBuilder);
	}

	public void launch()
	{
		application = buildApplication();
		var graphicPool = application.getGraphicPool();
		final var applicationAdapter = VulkanApplicationLauncher.launch(application);

		while (!applicationAdapter.shouldClose())
		{
			applicationAdapter.prepare();
			applicationAdapter.execute(graphicPool);
		}
	}

	private static VulkanApplication buildApplication()
	{
		final var meshConfiguration = new MeshConfiguration(WIDTH, HEIGHT, false);
		final var modelFactory = new MeshModelFactory(meshConfiguration);
		final var application = modelFactory.application;
		return application;
	}
}
