/**
 */
package org.sheepy.vulkan.model.graphicpipeline.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import org.sheepy.vulkan.model.graphicpipeline.*;

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
 * @see org.sheepy.vulkan.model.graphicpipeline.GraphicpipelinePackage
 * @generated
 */
public class GraphicpipelineSwitch<T> extends Switch<T>
{
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static GraphicpipelinePackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GraphicpipelineSwitch()
	{
		if (modelPackage == null)
		{
			modelPackage = GraphicpipelinePackage.eINSTANCE;
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
			case GraphicpipelinePackage.COLOR_BLEND:
			{
				ColorBlend colorBlend = (ColorBlend)theEObject;
				T result = caseColorBlend(colorBlend);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GraphicpipelinePackage.COLOR_BLEND_ATTACHMENT:
			{
				ColorBlendAttachment colorBlendAttachment = (ColorBlendAttachment)theEObject;
				T result = caseColorBlendAttachment(colorBlendAttachment);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GraphicpipelinePackage.INPUT_ASSEMBLY:
			{
				InputAssembly inputAssembly = (InputAssembly)theEObject;
				T result = caseInputAssembly(inputAssembly);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GraphicpipelinePackage.RASTERIZER:
			{
				Rasterizer rasterizer = (Rasterizer)theEObject;
				T result = caseRasterizer(rasterizer);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GraphicpipelinePackage.DYNAMIC_STATE:
			{
				DynamicState dynamicState = (DynamicState)theEObject;
				T result = caseDynamicState(dynamicState);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GraphicpipelinePackage.VIEWPORT_STATE:
			{
				ViewportState viewportState = (ViewportState)theEObject;
				T result = caseViewportState(viewportState);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GraphicpipelinePackage.STATIC_VIEWPORT_STATE:
			{
				StaticViewportState staticViewportState = (StaticViewportState)theEObject;
				T result = caseStaticViewportState(staticViewportState);
				if (result == null) result = caseViewportState(staticViewportState);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GraphicpipelinePackage.DYNAMIC_VIEWPORT_STATE:
			{
				DynamicViewportState dynamicViewportState = (DynamicViewportState)theEObject;
				T result = caseDynamicViewportState(dynamicViewportState);
				if (result == null) result = caseViewportState(dynamicViewportState);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GraphicpipelinePackage.VEC2_I:
			{
				Vec2I vec2I = (Vec2I)theEObject;
				T result = caseVec2I(vec2I);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GraphicpipelinePackage.VIEWPORT:
			{
				Viewport viewport = (Viewport)theEObject;
				T result = caseViewport(viewport);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GraphicpipelinePackage.SCISSOR:
			{
				Scissor scissor = (Scissor)theEObject;
				T result = caseScissor(scissor);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
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
	 * Returns the result of interpreting the object as an instance of '<em>Input Assembly</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Input Assembly</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInputAssembly(InputAssembly object)
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
	 * Returns the result of interpreting the object as an instance of '<em>Vec2 I</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Vec2 I</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVec2I(Vec2I object)
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

} //GraphicpipelineSwitch
