/**
 */
package org.sheepy.lily.vulkan.model.process.graphic.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import org.sheepy.lily.core.model.maintainer.Maintainable;

import org.sheepy.lily.core.model.types.LNamedElement;

import org.sheepy.lily.vulkan.model.IExecutionManager;
import org.sheepy.lily.vulkan.model.IProcess;
import org.sheepy.lily.vulkan.model.IResourceContainer;

import org.sheepy.lily.vulkan.model.process.AbstractProcess;
import org.sheepy.lily.vulkan.model.process.Configuration;
import org.sheepy.lily.vulkan.model.process.IPipeline;
import org.sheepy.lily.vulkan.model.process.IPipelineTask;
import org.sheepy.lily.vulkan.model.process.IProcessPart;

import org.sheepy.lily.vulkan.model.process.graphic.*;

import org.sheepy.vulkan.model.barrier.AbstractImageBarrier;
import org.sheepy.vulkan.model.barrier.Barrier;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage
 * @generated
 */
public class GraphicSwitch<T1> extends Switch<T1>
{
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static GraphicPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GraphicSwitch()
	{
		if (modelPackage == null)
		{
			modelPackage = GraphicPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage)
	{
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T1 doSwitch(int classifierID, EObject theEObject)
	{
		switch (classifierID)
		{
			case GraphicPackage.GRAPHIC_CONFIGURATION:
			{
				GraphicConfiguration graphicConfiguration = (GraphicConfiguration)theEObject;
				T1 result = caseGraphicConfiguration(graphicConfiguration);
				if (result == null) result = caseConfiguration(graphicConfiguration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GraphicPackage.COLOR_DOMAIN:
			{
				ColorDomain colorDomain = (ColorDomain)theEObject;
				T1 result = caseColorDomain(colorDomain);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GraphicPackage.SWAPCHAIN_CONFIGURATION:
			{
				SwapchainConfiguration swapchainConfiguration = (SwapchainConfiguration)theEObject;
				T1 result = caseSwapchainConfiguration(swapchainConfiguration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GraphicPackage.FRAMEBUFFER_CONFIGURATION:
			{
				FramebufferConfiguration framebufferConfiguration = (FramebufferConfiguration)theEObject;
				T1 result = caseFramebufferConfiguration(framebufferConfiguration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GraphicPackage.IMAGE_ATTACHMENT:
			{
				ImageAttachment imageAttachment = (ImageAttachment)theEObject;
				T1 result = caseImageAttachment(imageAttachment);
				if (result == null) result = caseExtraAttachment(imageAttachment);
				if (result == null) result = caseAttachment(imageAttachment);
				if (result == null) result = caseLNamedElement(imageAttachment);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GraphicPackage.DEPTH_ATTACHMENT:
			{
				DepthAttachment depthAttachment = (DepthAttachment)theEObject;
				T1 result = caseDepthAttachment(depthAttachment);
				if (result == null) result = caseExtraAttachment(depthAttachment);
				if (result == null) result = caseAttachment(depthAttachment);
				if (result == null) result = caseLNamedElement(depthAttachment);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GraphicPackage.RENDER_PASS_INFO:
			{
				RenderPassInfo renderPassInfo = (RenderPassInfo)theEObject;
				T1 result = caseRenderPassInfo(renderPassInfo);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GraphicPackage.SUBPASS:
			{
				Subpass subpass = (Subpass)theEObject;
				T1 result = caseSubpass(subpass);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GraphicPackage.ATTACHMENT_REF:
			{
				AttachmentRef attachmentRef = (AttachmentRef)theEObject;
				T1 result = caseAttachmentRef(attachmentRef);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GraphicPackage.SUBPASS_DEPENDENCY:
			{
				SubpassDependency subpassDependency = (SubpassDependency)theEObject;
				T1 result = caseSubpassDependency(subpassDependency);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GraphicPackage.ATTACHMENT:
			{
				Attachment attachment = (Attachment)theEObject;
				T1 result = caseAttachment(attachment);
				if (result == null) result = caseLNamedElement(attachment);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GraphicPackage.SWAP_IMAGE_ATTACHMENT:
			{
				SwapImageAttachment swapImageAttachment = (SwapImageAttachment)theEObject;
				T1 result = caseSwapImageAttachment(swapImageAttachment);
				if (result == null) result = caseAttachment(swapImageAttachment);
				if (result == null) result = caseLNamedElement(swapImageAttachment);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GraphicPackage.EXTRA_ATTACHMENT:
			{
				ExtraAttachment extraAttachment = (ExtraAttachment)theEObject;
				T1 result = caseExtraAttachment(extraAttachment);
				if (result == null) result = caseAttachment(extraAttachment);
				if (result == null) result = caseLNamedElement(extraAttachment);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GraphicPackage.GRAPHIC_PROCESS:
			{
				GraphicProcess graphicProcess = (GraphicProcess)theEObject;
				T1 result = caseGraphicProcess(graphicProcess);
				if (result == null) result = caseAbstractProcess(graphicProcess);
				if (result == null) result = caseMaintainable(graphicProcess);
				if (result == null) result = caseIProcess(graphicProcess);
				if (result == null) result = caseIResourceContainer(graphicProcess);
				if (result == null) result = caseLNamedElement(graphicProcess);
				if (result == null) result = caseIExecutionManager(graphicProcess);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GraphicPackage.GRAPHICS_PIPELINE:
			{
				GraphicsPipeline graphicsPipeline = (GraphicsPipeline)theEObject;
				T1 result = caseGraphicsPipeline(graphicsPipeline);
				if (result == null) result = caseIPipeline(graphicsPipeline);
				if (result == null) result = caseMaintainable(graphicsPipeline);
				if (result == null) result = caseLNamedElement(graphicsPipeline);
				if (result == null) result = caseIResourceContainer(graphicsPipeline);
				if (result == null) result = caseIProcessPart(graphicsPipeline);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GraphicPackage.SWAP_IMAGE_BARRIER:
			{
				SwapImageBarrier swapImageBarrier = (SwapImageBarrier)theEObject;
				T1 result = caseSwapImageBarrier(swapImageBarrier);
				if (result == null) result = caseAbstractImageBarrier(swapImageBarrier);
				if (result == null) result = caseBarrier(swapImageBarrier);
				if (result == null) result = caseLNamedElement(swapImageBarrier);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GraphicPackage.BLIT_TO_SWAP_IMAGE:
			{
				BlitToSwapImage blitToSwapImage = (BlitToSwapImage)theEObject;
				T1 result = caseBlitToSwapImage(blitToSwapImage);
				if (result == null) result = caseIPipelineTask(blitToSwapImage);
				if (result == null) result = caseLNamedElement(blitToSwapImage);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GraphicPackage.DRAW_INDEXED:
			{
				DrawIndexed drawIndexed = (DrawIndexed)theEObject;
				T1 result = caseDrawIndexed(drawIndexed);
				if (result == null) result = caseIPipelineTask(drawIndexed);
				if (result == null) result = caseLNamedElement(drawIndexed);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GraphicPackage.DRAW:
			{
				Draw draw = (Draw)theEObject;
				T1 result = caseDraw(draw);
				if (result == null) result = caseIPipelineTask(draw);
				if (result == null) result = caseLNamedElement(draw);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GraphicPackage.VERTEX_INPUT_STATE:
			{
				VertexInputState vertexInputState = (VertexInputState)theEObject;
				T1 result = caseVertexInputState(vertexInputState);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GraphicPackage.INPUT_DESCRIPTOR:
			{
				InputDescriptor inputDescriptor = (InputDescriptor)theEObject;
				T1 result = caseInputDescriptor(inputDescriptor);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GraphicPackage.ATTRIBUTE_DESCRIPTION:
			{
				AttributeDescription attributeDescription = (AttributeDescription)theEObject;
				T1 result = caseAttributeDescription(attributeDescription);
				if (result == null) result = caseLNamedElement(attributeDescription);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GraphicPackage.BIND_VERTEX_BUFFER:
			{
				BindVertexBuffer bindVertexBuffer = (BindVertexBuffer)theEObject;
				T1 result = caseBindVertexBuffer(bindVertexBuffer);
				if (result == null) result = caseIPipelineTask(bindVertexBuffer);
				if (result == null) result = caseLNamedElement(bindVertexBuffer);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GraphicPackage.SET_SCISSOR:
			{
				SetScissor setScissor = (SetScissor)theEObject;
				T1 result = caseSetScissor(setScissor);
				if (result == null) result = caseIPipelineTask(setScissor);
				if (result == null) result = caseLNamedElement(setScissor);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GraphicPackage.SET_VIEWPORT:
			{
				SetViewport setViewport = (SetViewport)theEObject;
				T1 result = caseSetViewport(setViewport);
				if (result == null) result = caseIPipelineTask(setViewport);
				if (result == null) result = caseLNamedElement(setViewport);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GraphicPackage.VERTEX_BINDING:
			{
				VertexBinding vertexBinding = (VertexBinding)theEObject;
				T1 result = caseVertexBinding(vertexBinding);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GraphicPackage.BIND_INDEX_BUFFER:
			{
				BindIndexBuffer bindIndexBuffer = (BindIndexBuffer)theEObject;
				T1 result = caseBindIndexBuffer(bindIndexBuffer);
				if (result == null) result = caseIPipelineTask(bindIndexBuffer);
				if (result == null) result = caseLNamedElement(bindIndexBuffer);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Configuration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseGraphicConfiguration(GraphicConfiguration object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Color Domain</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Color Domain</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseColorDomain(ColorDomain object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Swapchain Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Swapchain Configuration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseSwapchainConfiguration(SwapchainConfiguration object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Framebuffer Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Framebuffer Configuration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseFramebufferConfiguration(FramebufferConfiguration object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Image Attachment</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Image Attachment</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseImageAttachment(ImageAttachment object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Depth Attachment</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Depth Attachment</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseDepthAttachment(DepthAttachment object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Render Pass Info</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Render Pass Info</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseRenderPassInfo(RenderPassInfo object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Subpass</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Subpass</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseSubpass(Subpass object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Attachment Ref</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Attachment Ref</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseAttachmentRef(AttachmentRef object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Subpass Dependency</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Subpass Dependency</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseSubpassDependency(SubpassDependency object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Attachment</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Attachment</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseAttachment(Attachment object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Swap Image Attachment</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Swap Image Attachment</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseSwapImageAttachment(SwapImageAttachment object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Extra Attachment</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Extra Attachment</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseExtraAttachment(ExtraAttachment object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Process</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Process</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseGraphicProcess(GraphicProcess object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Graphics Pipeline</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Graphics Pipeline</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseGraphicsPipeline(GraphicsPipeline object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Swap Image Barrier</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Swap Image Barrier</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseSwapImageBarrier(SwapImageBarrier object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Blit To Swap Image</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Blit To Swap Image</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseBlitToSwapImage(BlitToSwapImage object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Draw Indexed</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Draw Indexed</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseDrawIndexed(DrawIndexed object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Draw</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Draw</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseDraw(Draw object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Vertex Input State</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Vertex Input State</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseVertexInputState(VertexInputState object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Input Descriptor</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Input Descriptor</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseInputDescriptor(InputDescriptor object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Attribute Description</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Attribute Description</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseAttributeDescription(AttributeDescription object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Bind Vertex Buffer</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Bind Vertex Buffer</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseBindVertexBuffer(BindVertexBuffer object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Set Scissor</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Set Scissor</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseSetScissor(SetScissor object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Set Viewport</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Set Viewport</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseSetViewport(SetViewport object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Vertex Binding</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Vertex Binding</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseVertexBinding(VertexBinding object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Bind Index Buffer</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Bind Index Buffer</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseBindIndexBuffer(BindIndexBuffer object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Configuration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseConfiguration(Configuration object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>LNamed Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>LNamed Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseLNamedElement(LNamedElement object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IResource Container</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IResource Container</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseIResourceContainer(IResourceContainer object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IExecution Manager</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IExecution Manager</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseIExecutionManager(IExecutionManager object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IProcess</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IProcess</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseIProcess(IProcess object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Abstract Process</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Abstract Process</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseAbstractProcess(AbstractProcess object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Maintainable</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Maintainable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public <T extends Maintainable<T>> T1 caseMaintainable(Maintainable<T> object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IProcess Part</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IProcess Part</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseIProcessPart(IProcessPart object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IPipeline</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IPipeline</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseIPipeline(IPipeline object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Barrier</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Barrier</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseBarrier(Barrier object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Abstract Image Barrier</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Abstract Image Barrier</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseAbstractImageBarrier(AbstractImageBarrier object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IPipeline Task</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IPipeline Task</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseIPipelineTask(IPipelineTask object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T1 defaultCase(EObject object)
	{
		return null;
	}

} //GraphicSwitch
