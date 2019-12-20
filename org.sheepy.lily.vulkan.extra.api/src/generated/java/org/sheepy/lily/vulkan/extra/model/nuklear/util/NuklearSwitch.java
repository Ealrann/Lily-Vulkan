/**
 */
package org.sheepy.lily.vulkan.extra.model.nuklear.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import org.sheepy.lily.core.model.inference.IInferenceObject;
import org.sheepy.lily.core.model.presentation.IPanel;
import org.sheepy.lily.core.model.presentation.IPositionElement;
import org.sheepy.lily.core.model.presentation.ISizedElement;
import org.sheepy.lily.core.model.presentation.IUIElement;
import org.sheepy.lily.core.model.types.LNamedElement;

import org.sheepy.lily.core.model.ui.Panel;
import org.sheepy.lily.vulkan.extra.model.nuklear.*;
import org.sheepy.lily.vulkan.model.process.IPipelineTask;
import org.sheepy.lily.vulkan.model.process.PushConstant;
import org.sheepy.lily.vulkan.model.resource.BufferDataProvider;

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
 * @see org.sheepy.lily.vulkan.extra.model.nuklear.NuklearPackage
 * @generated
 */
public class NuklearSwitch<T1> extends Switch<T1>
{
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static NuklearPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NuklearSwitch()
	{
		if (modelPackage == null)
		{
			modelPackage = NuklearPackage.eINSTANCE;
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
			case NuklearPackage.NUKLEAR_PUSH_CONSTANTS:
			{
				NuklearPushConstants nuklearPushConstants = (NuklearPushConstants)theEObject;
				T1 result = caseNuklearPushConstants(nuklearPushConstants);
				if (result == null) result = casePushConstant(nuklearPushConstants);
				if (result == null) result = caseIPipelineTask(nuklearPushConstants);
				if (result == null) result = caseLNamedElement(nuklearPushConstants);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NuklearPackage.NUKLEAR_LAYOUT_TASK:
			{
				NuklearLayoutTask nuklearLayoutTask = (NuklearLayoutTask)theEObject;
				T1 result = caseNuklearLayoutTask(nuklearLayoutTask);
				if (result == null) result = caseIPipelineTask(nuklearLayoutTask);
				if (result == null) result = caseLNamedElement(nuklearLayoutTask);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NuklearPackage.NUKLEAR_CONTEXT:
			{
				NuklearContext nuklearContext = (NuklearContext)theEObject;
				T1 result = caseNuklearContext(nuklearContext);
				if (result == null) result = caseIResource(nuklearContext);
				if (result == null) result = caseLNamedElement(nuklearContext);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NuklearPackage.NUKLEAR_FONT:
			{
				NuklearFont nuklearFont = (NuklearFont)theEObject;
				T1 result = caseNuklearFont(nuklearFont);
				if (result == null) result = caseIResource(nuklearFont);
				if (result == null) result = caseLNamedElement(nuklearFont);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NuklearPackage.SELECTOR_PANEL:
			{
				SelectorPanel selectorPanel = (SelectorPanel)theEObject;
				T1 result = caseSelectorPanel(selectorPanel);
				if (result == null) result = caseIPanel(selectorPanel);
				if (result == null) result = caseLNamedElement(selectorPanel);
				if (result == null) result = caseIUIElement(selectorPanel);
				if (result == null) result = caseIPositionElement(selectorPanel);
				if (result == null) result = caseIInferenceObject(selectorPanel);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NuklearPackage.IINPUT_PROVIDER:
			{
				IInputProvider iInputProvider = (IInputProvider)theEObject;
				T1 result = caseIInputProvider(iInputProvider);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NuklearPackage.PANEL_VIEWER:
			{
				PanelViewer panelViewer = (PanelViewer)theEObject;
				T1 result = casePanelViewer(panelViewer);
				if (result == null) result = casePanel(panelViewer);
				if (result == null) result = caseIPanel(panelViewer);
				if (result == null) result = caseISizedElement(panelViewer);
				if (result == null) result = caseLNamedElement(panelViewer);
				if (result == null) result = caseIUIElement(panelViewer);
				if (result == null) result = caseIPositionElement(panelViewer);
				if (result == null) result = caseIInferenceObject(panelViewer);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NuklearPackage.NUKLEAR_VERTEX_PROVIDER:
			{
				NuklearVertexProvider nuklearVertexProvider = (NuklearVertexProvider)theEObject;
				T1 result = caseNuklearVertexProvider(nuklearVertexProvider);
				if (result == null) result = caseBufferDataProvider(nuklearVertexProvider);
				if (result == null) result = caseLNamedElement(nuklearVertexProvider);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NuklearPackage.NUKLEAR_INDEX_PROVIDER:
			{
				NuklearIndexProvider nuklearIndexProvider = (NuklearIndexProvider)theEObject;
				T1 result = caseNuklearIndexProvider(nuklearIndexProvider);
				if (result == null) result = caseBufferDataProvider(nuklearIndexProvider);
				if (result == null) result = caseLNamedElement(nuklearIndexProvider);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Push Constants</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Push Constants</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseNuklearPushConstants(NuklearPushConstants object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Layout Task</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Layout Task</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseNuklearLayoutTask(NuklearLayoutTask object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Context</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Context</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseNuklearContext(NuklearContext object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Font</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Font</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseNuklearFont(NuklearFont object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Selector Panel</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Selector Panel</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseSelectorPanel(SelectorPanel object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IInput Provider</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IInput Provider</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseIInputProvider(IInputProvider object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Panel Viewer</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Panel Viewer</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 casePanelViewer(PanelViewer object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Vertex Provider</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Vertex Provider</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseNuklearVertexProvider(NuklearVertexProvider object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Index Provider</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Index Provider</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseNuklearIndexProvider(NuklearIndexProvider object)
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
	 * Returns the result of interpreting the object as an instance of '<em>Push Constant</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Push Constant</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 casePushConstant(PushConstant object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IResource</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IResource</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseIResource(org.sheepy.lily.core.model.application.IResource object)
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
	public T1 caseIInferenceObject(IInferenceObject object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IUI Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IUI Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseIUIElement(IUIElement object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IPosition Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IPosition Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseIPositionElement(IPositionElement object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IPanel</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IPanel</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseIPanel(IPanel object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>ISized Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>ISized Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseISizedElement(ISizedElement object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Panel</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Panel</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 casePanel(Panel object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Buffer Data Provider</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Buffer Data Provider</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public <T> T1 caseBufferDataProvider(BufferDataProvider<T> object)
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

} //NuklearSwitch
