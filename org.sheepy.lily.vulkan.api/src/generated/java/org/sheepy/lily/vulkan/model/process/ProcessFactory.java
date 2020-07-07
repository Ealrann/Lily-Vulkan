/**
 */
package org.sheepy.lily.vulkan.model.process;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.sheepy.lily.vulkan.model.process.ProcessPackage
 * @generated
 */
public interface ProcessFactory extends EFactory
{
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ProcessFactory eINSTANCE = org.sheepy.lily.vulkan.model.process.impl.ProcessFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Pipeline Pkg</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Pipeline Pkg</em>'.
	 * @generated
	 */
	PipelinePkg createPipelinePkg();

	/**
	 * Returns a new object of class '<em>Task Pkg</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Task Pkg</em>'.
	 * @generated
	 */
	TaskPkg createTaskPkg();

	/**
	 * Returns a new object of class '<em>Pipeline</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Pipeline</em>'.
	 * @generated
	 */
	Pipeline createPipeline();

	/**
	 * Returns a new object of class '<em>Composite Pipeline</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Composite Pipeline</em>'.
	 * @generated
	 */
	CompositePipeline createCompositePipeline();

	/**
	 * Returns a new object of class '<em>Pipeline Barrier</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Pipeline Barrier</em>'.
	 * @generated
	 */
	PipelineBarrier createPipelineBarrier();

	/**
	 * Returns a new object of class '<em>Composite Task</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Composite Task</em>'.
	 * @generated
	 */
	CompositeTask createCompositeTask();

	/**
	 * Returns a new object of class '<em>Bind Descriptor Sets</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Bind Descriptor Sets</em>'.
	 * @generated
	 */
	BindDescriptorSets createBindDescriptorSets();

	/**
	 * Returns a new object of class '<em>Push Constant Buffer</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Push Constant Buffer</em>'.
	 * @generated
	 */
	PushConstantBuffer createPushConstantBuffer();

	/**
	 * Returns a new object of class '<em>Flush Transfer Buffer Task</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Flush Transfer Buffer Task</em>'.
	 * @generated
	 */
	FlushTransferBufferTask createFlushTransferBufferTask();

	/**
	 * Returns a new object of class '<em>Copy Buffer Task</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Copy Buffer Task</em>'.
	 * @generated
	 */
	CopyBufferTask createCopyBufferTask();

	/**
	 * Returns a new object of class '<em>Extension Pkg</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Extension Pkg</em>'.
	 * @generated
	 */
	ProcessExtensionPkg createProcessExtensionPkg();

	/**
	 * Returns a new object of class '<em>Prepare Composite Transfer</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Prepare Composite Transfer</em>'.
	 * @generated
	 */
	PrepareCompositeTransfer createPrepareCompositeTransfer();

	/**
	 * Returns a new object of class '<em>Swap Bindings Task</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Swap Bindings Task</em>'.
	 * @generated
	 */
	SwapBindingsTask createSwapBindingsTask();

	/**
	 * Returns a new object of class '<em>Fetch Buffer</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Fetch Buffer</em>'.
	 * @generated
	 */
	FetchBuffer createFetchBuffer();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	ProcessPackage getProcessPackage();

} //ProcessFactory
