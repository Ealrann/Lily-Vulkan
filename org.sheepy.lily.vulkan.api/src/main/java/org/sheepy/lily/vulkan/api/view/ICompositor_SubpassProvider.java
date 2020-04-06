package org.sheepy.lily.vulkan.api.view;

import org.sheepy.lily.core.api.adapter.IAdapter;
import org.sheepy.lily.core.model.application.ICompositor;
import org.sheepy.lily.vulkan.model.process.graphic.AttachmentPkg;
import org.sheepy.lily.vulkan.model.process.graphic.Subpass;

public interface ICompositor_SubpassProvider<T extends ICompositor> extends IAdapter
{
	Subpass build(T part, AttachmentPkg attachmentPkg);
}