/**
 */
package org.sheepy.lily.vulkan.model.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;
import org.sheepy.lily.core.model.application.IEngine;
import org.sheepy.lily.core.model.cadence.ICadenceTask;
import org.sheepy.lily.core.model.types.LNamedElement;

import org.sheepy.lily.core.model.variable.IModelVariable;
import org.sheepy.lily.vulkan.model.*;

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
 * @see org.sheepy.lily.vulkan.model.VulkanPackage
 * @generated
 */
public class VulkanSwitch<T> extends Switch<T>
{
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static VulkanPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VulkanSwitch()
	{
		if (modelPackage == null)
		{
			modelPackage = VulkanPackage.eINSTANCE;
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
			case VulkanPackage.VULKAN_ENGINE:
			{
				VulkanEngine vulkanEngine = (VulkanEngine)theEObject;
				T result = caseVulkanEngine(vulkanEngine);
				if (result == null) result = caseIEngine(vulkanEngine);
				if (result == null) result = caseIResourceContainer(vulkanEngine);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case VulkanPackage.IRESOURCE_CONTAINER:
			{
				IResourceContainer iResourceContainer = (IResourceContainer)theEObject;
				T result = caseIResourceContainer(iResourceContainer);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case VulkanPackage.VULKAN_RESOURCE_PKG:
			{
				VulkanResourcePkg vulkanResourcePkg = (VulkanResourcePkg)theEObject;
				T result = caseVulkanResourcePkg(vulkanResourcePkg);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case VulkanPackage.IVULKAN_RESOURCE:
			{
				IVulkanResource iVulkanResource = (IVulkanResource)theEObject;
				T result = caseIVulkanResource(iVulkanResource);
				if (result == null) result = caseLNamedElement(iVulkanResource);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case VulkanPackage.IPROCESS:
			{
				IProcess iProcess = (IProcess)theEObject;
				T result = caseIProcess(iProcess);
				if (result == null) result = caseIResourceContainer(iProcess);
				if (result == null) result = caseLNamedElement(iProcess);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case VulkanPackage.RUN_PROCESS:
			{
				RunProcess runProcess = (RunProcess)theEObject;
				T result = caseRunProcess(runProcess);
				if (result == null) result = caseICadenceTask(runProcess);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case VulkanPackage.WAIT_PROCESS_IDLE:
			{
				WaitProcessIdle waitProcessIdle = (WaitProcessIdle)theEObject;
				T result = caseWaitProcessIdle(waitProcessIdle);
				if (result == null) result = caseICadenceTask(waitProcessIdle);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case VulkanPackage.DESCRIPTOR_PKG:
			{
				DescriptorPkg descriptorPkg = (DescriptorPkg)theEObject;
				T result = caseDescriptorPkg(descriptorPkg);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case VulkanPackage.IDESCRIPTOR:
			{
				IDescriptor iDescriptor = (IDescriptor)theEObject;
				T result = caseIDescriptor(iDescriptor);
				if (result == null) result = caseLNamedElement(iDescriptor);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case VulkanPackage.MOUSE_LOCATION:
			{
				MouseLocation mouseLocation = (MouseLocation)theEObject;
				T result = caseMouseLocation(mouseLocation);
				if (result == null) result = caseIModelVariable(mouseLocation);
				if (result == null) result = caseLNamedElement(mouseLocation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Engine</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Engine</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVulkanEngine(VulkanEngine object)
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
	public T caseIResourceContainer(IResourceContainer object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Resource Pkg</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Resource Pkg</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVulkanResourcePkg(VulkanResourcePkg object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IVulkan Resource</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IVulkan Resource</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIVulkanResource(IVulkanResource object)
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
	 * Returns the result of interpreting the object as an instance of '<em>Run Process</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Run Process</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRunProcess(RunProcess object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Wait Process Idle</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Wait Process Idle</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseWaitProcessIdle(WaitProcessIdle object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Descriptor Pkg</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Descriptor Pkg</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDescriptorPkg(DescriptorPkg object)
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
	public T caseIDescriptor(IDescriptor object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Mouse Location</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Mouse Location</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMouseLocation(MouseLocation object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IEngine</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IEngine</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIEngine(IEngine object)
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
	 * Returns the result of interpreting the object as an instance of '<em>ICadence Task</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>ICadence Task</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseICadenceTask(ICadenceTask object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IModel Variable</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IModel Variable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIModelVariable(IModelVariable object)
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

} //VulkanSwitch
