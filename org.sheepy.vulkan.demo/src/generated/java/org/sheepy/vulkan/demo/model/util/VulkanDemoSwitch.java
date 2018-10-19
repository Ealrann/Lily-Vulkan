/**
 */
package org.sheepy.vulkan.demo.model.util;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import org.sheepy.vulkan.demo.model.*;

import org.sheepy.vulkan.model.process.AbstractPipeline;
import org.sheepy.vulkan.model.process.GraphicsPipeline;
import org.sheepy.vulkan.model.process.IProcessUnit;

import org.sheepy.vulkan.model.resource.IDescriptor;
import org.sheepy.vulkan.model.resource.IndexedBuffer;
import org.sheepy.vulkan.model.resource.Resource;
import org.sheepy.vulkan.model.resource.VulkanBuffer;

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
 * @see org.sheepy.vulkan.demo.model.VulkanDemoPackage
 * @generated
 */
public class VulkanDemoSwitch
{
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static VulkanDemoPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VulkanDemoSwitch()
	{
		if (modelPackage == null)
		{
			modelPackage = VulkanDemoPackage.eINSTANCE;
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	public Object doSwitch(EObject theEObject)
	{
		return doSwitch(theEObject.eClass(), theEObject);
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected Object doSwitch(EClass theEClass, EObject theEObject)
	{
		if (theEClass.eContainer() == modelPackage)
		{
			return doSwitch(theEClass.getClassifierID(), theEObject);
		}
		else
		{
			List eSuperTypes = theEClass.getESuperTypes();
			return
				eSuperTypes.isEmpty() ?
					defaultCase(theEObject) :
					doSwitch((EClass)eSuperTypes.get(0), theEObject);
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected Object doSwitch(int classifierID, EObject theEObject)
	{
		switch (classifierID)
		{
			case VulkanDemoPackage.MESH_PIPELINE:
			{
				MeshPipeline meshPipeline = (MeshPipeline)theEObject;
				Object result = caseMeshPipeline(meshPipeline);
				if (result == null) result = caseGraphicsPipeline(meshPipeline);
				if (result == null) result = caseAbstractPipeline(meshPipeline);
				if (result == null) result = caseIProcessUnit(meshPipeline);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case VulkanDemoPackage.MESH_BUFFER:
			{
				MeshBuffer meshBuffer = (MeshBuffer)theEObject;
				Object result = caseMeshBuffer(meshBuffer);
				if (result == null) result = caseIndexedBuffer(meshBuffer);
				if (result == null) result = caseVulkanBuffer(meshBuffer);
				if (result == null) result = caseIDescriptor(meshBuffer);
				if (result == null) result = caseResource(meshBuffer);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case VulkanDemoPackage.UNIFORM_BUFFER:
			{
				UniformBuffer uniformBuffer = (UniformBuffer)theEObject;
				Object result = caseUniformBuffer(uniformBuffer);
				if (result == null) result = caseVulkanBuffer(uniformBuffer);
				if (result == null) result = caseIDescriptor(uniformBuffer);
				if (result == null) result = caseResource(uniformBuffer);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Mesh Pipeline</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Mesh Pipeline</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseMeshPipeline(MeshPipeline object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Mesh Buffer</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Mesh Buffer</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseMeshBuffer(MeshBuffer object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Uniform Buffer</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Uniform Buffer</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseUniformBuffer(UniformBuffer object)
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
	public Object caseIProcessUnit(IProcessUnit object)
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
	public Object caseAbstractPipeline(AbstractPipeline object)
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
	public Object caseGraphicsPipeline(GraphicsPipeline object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Resource</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Resource</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseResource(Resource object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Vulkan Buffer</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Vulkan Buffer</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseVulkanBuffer(VulkanBuffer object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IDescriptor</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IDescriptor</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseIDescriptor(IDescriptor object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Indexed Buffer</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Indexed Buffer</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseIndexedBuffer(IndexedBuffer object)
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
	public Object defaultCase(EObject object)
	{
		return null;
	}

} //VulkanDemoSwitch
