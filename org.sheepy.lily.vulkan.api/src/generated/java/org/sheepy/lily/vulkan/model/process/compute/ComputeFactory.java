/**
 */
package org.sheepy.lily.vulkan.model.process.compute;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.sheepy.lily.vulkan.model.process.compute.ComputePackage
 * @generated
 */
public interface ComputeFactory extends EFactory
{
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ComputeFactory eINSTANCE = org.sheepy.lily.vulkan.model.process.compute.impl.ComputeFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Process</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Process</em>'.
	 * @generated
	 */
	ComputeProcess createComputeProcess();

	/**
	 * Returns a new object of class '<em>Pipeline</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Pipeline</em>'.
	 * @generated
	 */
	ComputePipeline createComputePipeline();

	/**
	 * Returns a new object of class '<em>Dispatch Task</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Dispatch Task</em>'.
	 * @generated
	 */
	DispatchTask createDispatchTask();

	/**
	 * Returns a new object of class '<em>Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Configuration</em>'.
	 * @generated
	 */
	ComputeConfiguration createComputeConfiguration();

	/**
	 * Returns a new object of class '<em>Execution Manager</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Execution Manager</em>'.
	 * @generated
	 */
	ComputeExecutionManager createComputeExecutionManager();

	/**
	 * Returns a new object of class '<em>Execution Recorder</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Execution Recorder</em>'.
	 * @generated
	 */
	ComputeExecutionRecorder createComputeExecutionRecorder();

	/**
	 * Returns a new object of class '<em>Command Buffer</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Command Buffer</em>'.
	 * @generated
	 */
	ComputeCommandBuffer createComputeCommandBuffer();

	/**
	 * Returns a new object of class '<em>Acquirer</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Acquirer</em>'.
	 * @generated
	 */
	ComputeAcquirer createComputeAcquirer();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	ComputePackage getComputePackage();

} //ComputeFactory
