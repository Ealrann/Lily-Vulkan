/**
 */
package org.sheepy.vulkan.model.barrier;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.sheepy.vulkan.model.barrier.BarrierPackage
 * @generated
 */
public interface BarrierFactory extends EFactory
{
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	BarrierFactory eINSTANCE = org.sheepy.vulkan.model.barrier.impl.BarrierFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Reference Buffer Barrier</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Reference Buffer Barrier</em>'.
	 * @generated
	 */
	ReferenceBufferBarrier createReferenceBufferBarrier();

	/**
	 * Returns a new object of class '<em>Reference Image Barrier</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Reference Image Barrier</em>'.
	 * @generated
	 */
	ReferenceImageBarrier createReferenceImageBarrier();

	/**
	 * Returns a new object of class '<em>Image Transition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Image Transition</em>'.
	 * @generated
	 */
	ImageTransition createImageTransition();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	BarrierPackage getBarrierPackage();

} //BarrierFactory
