package org.sheepy.vulkan.resource.buffer;

import static org.lwjgl.vulkan.VK10.vkCmdPushConstants;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EClass;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkCommandBuffer;
import org.lwjgl.vulkan.VkPushConstantRange;
import org.sheepy.common.api.adapter.IServiceAdapterFactory;
import org.sheepy.common.api.adapter.impl.AbstractStatefullAdapter;
import org.sheepy.vulkan.api.adapter.IVulkanAdapter;
import org.sheepy.vulkan.model.enumeration.EShaderStage;
import org.sheepy.vulkan.model.resource.PushConstant;
import org.sheepy.vulkan.model.resource.ResourcePackage;

public class PushConstantAdapter extends AbstractStatefullAdapter implements IVulkanAdapter
{
	protected PushConstant pushConstant;

	protected boolean needPush = true;

	@Override
	public void notifyChanged(Notification notification)
	{
		super.notifyChanged(notification);

		if (notification.getFeature() == ResourcePackage.Literals.PUSH_CONSTANT__DATA)
		{
			needPush = true;
		}
	}

	@Override
	public void setTarget(Notifier target)
	{
		pushConstant = (PushConstant) target;
	}

	public VkPushConstantRange.Buffer allocRange(MemoryStack stack)
	{
		final int size = pushConstant.getData().capacity();
		final EShaderStage stage = pushConstant.getStage();

		final VkPushConstantRange.Buffer pushConstantRange = VkPushConstantRange.callocStack(1,
				stack);
		pushConstantRange.get(0).set(stage.getValue(), 0, size);

		return pushConstantRange;
	}

	public void pushConstants(VkCommandBuffer commandBuffer, long pipelineLayout)
	{
		final EShaderStage stage = pushConstant.getStage();
		vkCmdPushConstants(commandBuffer, pipelineLayout, stage.getValue(), 0,
				pushConstant.getData());
		needPush = false;
	}

	public boolean needRecord()
	{
		return needPush;
	}

	@Override
	public boolean isApplicable(EClass eClass)
	{
		return ResourcePackage.Literals.PUSH_CONSTANT == eClass;
	}

	public static PushConstantAdapter adapt(PushConstant object)
	{
		return IServiceAdapterFactory.INSTANCE.adapt(object, PushConstantAdapter.class);
	}
}
