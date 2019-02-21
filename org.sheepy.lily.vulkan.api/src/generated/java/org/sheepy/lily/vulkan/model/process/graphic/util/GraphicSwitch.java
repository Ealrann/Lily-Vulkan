/**
 */
package org.sheepy.lily.vulkan.model.process.graphic.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import org.sheepy.lily.core.model.inference.IInferenceObject;

import org.sheepy.lily.core.model.root.LObject;

import org.sheepy.lily.core.model.types.LNamedElement;

import org.sheepy.lily.vulkan.model.IEnginePart;
import org.sheepy.lily.vulkan.model.IProcess;

import org.sheepy.lily.vulkan.model.process.AbstractPipeline;
import org.sheepy.lily.vulkan.model.process.AbstractProcess;
import org.sheepy.lily.vulkan.model.process.Configuration;
import org.sheepy.lily.vulkan.model.process.IPipeline;
import org.sheepy.lily.vulkan.model.process.IProcessUnit;

import org.sheepy.lily.vulkan.model.process.graphic.*;

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
public class GraphicSwitch<T> extends Switch<T>
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
	protected T doSwitch(int classifierID, EObject theEObject)
	{
		switch (classifierID)
		{
			case GraphicPackage.GRAPHIC_CONFIGURATION:
			{
				GraphicConfiguration graphicConfiguration = (GraphicConfiguration)theEObject;
				T result = caseGraphicConfiguration(graphicConfiguration);
				if (result == null) result = caseConfiguration(graphicConfiguration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GraphicPackage.RENDER_PASS_INFO:
			{
				RenderPassInfo renderPassInfo = (RenderPassInfo)theEObject;
				T result = caseRenderPassInfo(renderPassInfo);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GraphicPackage.SUBPASS:
			{
				Subpass subpass = (Subpass)theEObject;
				T result = caseSubpass(subpass);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GraphicPackage.ATTACHEMENT_REF:
			{
				AttachementRef attachementRef = (AttachementRef)theEObject;
				T result = caseAttachementRef(attachementRef);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GraphicPackage.SUBPASS_DEPENDENCY:
			{
				SubpassDependency subpassDependency = (SubpassDependency)theEObject;
				T result = caseSubpassDependency(subpassDependency);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GraphicPackage.ATTACHMENT_DESCRIPTION:
			{
				AttachmentDescription attachmentDescription = (AttachmentDescription)theEObject;
				T result = caseAttachmentDescription(attachmentDescription);
				if (result == null) result = caseLNamedElement(attachmentDescription);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GraphicPackage.DEPTH_ATTACHMENT_DESCRIPTION:
			{
				DepthAttachmentDescription depthAttachmentDescription = (DepthAttachmentDescription)theEObject;
				T result = caseDepthAttachmentDescription(depthAttachmentDescription);
				if (result == null) result = caseAttachmentDescription(depthAttachmentDescription);
				if (result == null) result = caseLNamedElement(depthAttachmentDescription);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GraphicPackage.GRAPHIC_PROCESS:
			{
				GraphicProcess graphicProcess = (GraphicProcess)theEObject;
				T result = caseGraphicProcess(graphicProcess);
				if (result == null) result = caseAbstractProcess(graphicProcess);
				if (result == null) result = caseIProcess(graphicProcess);
				if (result == null) result = caseIEnginePart(graphicProcess);
				if (result == null) result = caseLNamedElement(graphicProcess);
				if (result == null) result = caseLObject(graphicProcess);
				if (result == null) result = caseIInferenceObject(graphicProcess);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GraphicPackage.IGRAPHICS_PIPELINE:
			{
				IGraphicsPipeline iGraphicsPipeline = (IGraphicsPipeline)theEObject;
				T result = caseIGraphicsPipeline(iGraphicsPipeline);
				if (result == null) result = caseIPipeline(iGraphicsPipeline);
				if (result == null) result = caseIProcessUnit(iGraphicsPipeline);
				if (result == null) result = caseLNamedElement(iGraphicsPipeline);
				if (result == null) result = caseLObject(iGraphicsPipeline);
				if (result == null) result = caseIInferenceObject(iGraphicsPipeline);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GraphicPackage.IGUI_PIPELINE:
			{
				IGUIPipeline iguiPipeline = (IGUIPipeline)theEObject;
				T result = caseIGUIPipeline(iguiPipeline);
				if (result == null) result = caseIGraphicsPipeline(iguiPipeline);
				if (result == null) result = caseIPipeline(iguiPipeline);
				if (result == null) result = caseIProcessUnit(iguiPipeline);
				if (result == null) result = caseLNamedElement(iguiPipeline);
				if (result == null) result = caseLObject(iguiPipeline);
				if (result == null) result = caseIInferenceObject(iguiPipeline);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GraphicPackage.GRAPHICS_PIPELINE:
			{
				GraphicsPipeline graphicsPipeline = (GraphicsPipeline)theEObject;
				T result = caseGraphicsPipeline(graphicsPipeline);
				if (result == null) result = caseAbstractPipeline(graphicsPipeline);
				if (result == null) result = caseIGraphicsPipeline(graphicsPipeline);
				if (result == null) result = caseIPipeline(graphicsPipeline);
				if (result == null) result = caseIProcessUnit(graphicsPipeline);
				if (result == null) result = caseLNamedElement(graphicsPipeline);
				if (result == null) result = caseLObject(graphicsPipeline);
				if (result == null) result = caseIInferenceObject(graphicsPipeline);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GraphicPackage.DYNAMIC_STATE:
			{
				DynamicState dynamicState = (DynamicState)theEObject;
				T result = caseDynamicState(dynamicState);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GraphicPackage.COLOR_BLEND:
			{
				ColorBlend colorBlend = (ColorBlend)theEObject;
				T result = caseColorBlend(colorBlend);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GraphicPackage.COLOR_BLEND_ATTACHMENT:
			{
				ColorBlendAttachment colorBlendAttachment = (ColorBlendAttachment)theEObject;
				T result = caseColorBlendAttachment(colorBlendAttachment);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GraphicPackage.VIEWPORT_STATE:
			{
				ViewportState viewportState = (ViewportState)theEObject;
				T result = caseViewportState(viewportState);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GraphicPackage.STATIC_VIEWPORT_STATE:
			{
				StaticViewportState staticViewportState = (StaticViewportState)theEObject;
				T result = caseStaticViewportState(staticViewportState);
				if (result == null) result = caseViewportState(staticViewportState);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GraphicPackage.DYNAMIC_VIEWPORT_STATE:
			{
				DynamicViewportState dynamicViewportState = (DynamicViewportState)theEObject;
				T result = caseDynamicViewportState(dynamicViewportState);
				if (result == null) result = caseViewportState(dynamicViewportState);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GraphicPackage.VIEWPORT:
			{
				Viewport viewport = (Viewport)theEObject;
				T result = caseViewport(viewport);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GraphicPackage.SCISSOR:
			{
				Scissor scissor = (Scissor)theEObject;
				T result = caseScissor(scissor);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GraphicPackage.RASTERIZER:
			{
				Rasterizer rasterizer = (Rasterizer)theEObject;
				T result = caseRasterizer(rasterizer);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GraphicPackage.IMAGE_PIPELINE:
			{
				ImagePipeline imagePipeline = (ImagePipeline)theEObject;
				T result = caseImagePipeline(imagePipeline);
				if (result == null) result = caseAbstractPipeline(imagePipeline);
				if (result == null) result = caseIPipeline(imagePipeline);
				if (result == null) result = caseIProcessUnit(imagePipeline);
				if (result == null) result = caseLNamedElement(imagePipeline);
				if (result == null) result = caseLObject(imagePipeline);
				if (result == null) result = caseIInferenceObject(imagePipeline);
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
	public T caseGraphicConfiguration(GraphicConfiguration object)
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
	public T caseRenderPassInfo(RenderPassInfo object)
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
	public T caseSubpass(Subpass object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Attachement Ref</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Attachement Ref</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAttachementRef(AttachementRef object)
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
	public T caseSubpassDependency(SubpassDependency object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Attachment Description</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Attachment Description</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAttachmentDescription(AttachmentDescription object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Depth Attachment Description</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Depth Attachment Description</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDepthAttachmentDescription(DepthAttachmentDescription object)
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
	public T caseGraphicProcess(GraphicProcess object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IGraphics Pipeline</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IGraphics Pipeline</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIGraphicsPipeline(IGraphicsPipeline object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IGUI Pipeline</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IGUI Pipeline</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIGUIPipeline(IGUIPipeline object)
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
	public T caseGraphicsPipeline(GraphicsPipeline object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Dynamic State</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Dynamic State</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDynamicState(DynamicState object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Color Blend</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Color Blend</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseColorBlend(ColorBlend object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Color Blend Attachment</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Color Blend Attachment</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseColorBlendAttachment(ColorBlendAttachment object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Viewport State</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Viewport State</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseViewportState(ViewportState object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Static Viewport State</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Static Viewport State</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStaticViewportState(StaticViewportState object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Dynamic Viewport State</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Dynamic Viewport State</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDynamicViewportState(DynamicViewportState object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Viewport</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Viewport</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseViewport(Viewport object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Scissor</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Scissor</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseScissor(Scissor object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Rasterizer</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Rasterizer</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRasterizer(Rasterizer object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Image Pipeline</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Image Pipeline</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseImagePipeline(ImagePipeline object)
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
	public T caseConfiguration(Configuration object)
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
	public T caseLNamedElement(LNamedElement object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IInference Object</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IInference Object</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIInferenceObject(IInferenceObject object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>LObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>LObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLObject(LObject object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IEngine Part</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IEngine Part</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIEnginePart(IEnginePart object)
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
	public T caseIProcess(IProcess object)
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
	public T caseAbstractProcess(AbstractProcess object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IProcess Unit</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IProcess Unit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIProcessUnit(IProcessUnit object)
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
	public T caseIPipeline(IPipeline object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Abstract Pipeline</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Abstract Pipeline</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAbstractPipeline(AbstractPipeline object)
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
	public T defaultCase(EObject object)
	{
		return null;
	}

} //GraphicSwitch
