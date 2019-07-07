import org.sheepy.lily.core.api.adapter.annotation.Adapters;
import org.sheepy.lily.vulkan.resource.buffer.BufferAdapter;
import org.sheepy.lily.vulkan.resource.buffer.BufferReferenceAdapter;
import org.sheepy.lily.vulkan.resource.buffer.CompositeBufferAdapter;
import org.sheepy.lily.vulkan.resource.buffer.CompositeBufferReferenceAdapter;
import org.sheepy.lily.vulkan.resource.buffer.PushBufferAdapter;
import org.sheepy.lily.vulkan.resource.file.FileResourceAdapter;
import org.sheepy.lily.vulkan.resource.file.ModuleResourceAdapter;
import org.sheepy.lily.vulkan.resource.file.StringModuleResourceAdapter;
import org.sheepy.lily.vulkan.resource.image.ImageAdapter;
import org.sheepy.lily.vulkan.resource.semaphore.SemaphoreAdapter;
import org.sheepy.lily.vulkan.resource.shader.ShaderAdapter;
import org.sheepy.lily.vulkan.resource.texture.FontAdapter;
import org.sheepy.lily.vulkan.resource.texture.TextureAdapter;

@Adapters(classifiers = {
		ShaderAdapter.class,
		BufferAdapter.class,
		CompositeBufferAdapter.class,
		PushBufferAdapter.class,
		ImageAdapter.class,
		TextureAdapter.class,
		FileResourceAdapter.class,
		ModuleResourceAdapter.class,
		StringModuleResourceAdapter.class,
		FontAdapter.class,
		SemaphoreAdapter.class,
		BufferReferenceAdapter.class,
		CompositeBufferReferenceAdapter.class
})

module org.sheepy.lily.vulkan.resource
{
	requires transitive org.sheepy.lily.vulkan.common;

	exports org.sheepy.lily.vulkan.resource.image;
	exports org.sheepy.lily.vulkan.resource.texture;
	exports org.sheepy.lily.vulkan.resource.semaphore;

	opens org.sheepy.lily.vulkan.resource.buffer;
	opens org.sheepy.lily.vulkan.resource.file;
	opens org.sheepy.lily.vulkan.resource.image;
	opens org.sheepy.lily.vulkan.resource.semaphore;
	opens org.sheepy.lily.vulkan.resource.shader;
	opens org.sheepy.lily.vulkan.resource.texture;
}
