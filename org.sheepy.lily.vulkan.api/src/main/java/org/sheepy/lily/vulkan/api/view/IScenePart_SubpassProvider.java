package org.sheepy.lily.vulkan.api.view;

import org.sheepy.lily.core.api.adapter.IAdapter;
import org.sheepy.lily.core.model.application.IScenePart;
import org.sheepy.lily.vulkan.model.process.graphic.AttachmentPkg;
import org.sheepy.lily.vulkan.model.process.graphic.Subpass;

public interface IScenePart_SubpassProvider<T extends IScenePart> extends IAdapter
{
	Subpass build(T part, AttachmentPkg attachmentPkg);
}
