/**
 */
package org.sheepy.vulkan.model.process;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.sheepy.vulkan.model.process.ProcessPackage
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
	ProcessFactory eINSTANCE = org.sheepy.vulkan.model.process.impl.ProcessFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Pipeline Buffer Barrier</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Pipeline Buffer Barrier</em>'.
	 * @generated
	 */
	PipelineBufferBarrier createPipelineBufferBarrier();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	ProcessPackage getProcessPackage();

} //ProcessFactory