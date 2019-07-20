/**
 */
package org.sheepy.vulkan.model.image;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.sheepy.vulkan.model.image.ImagePackage
 * @generated
 */
public interface ImageFactory extends EFactory
{
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ImageFactory eINSTANCE = org.sheepy.vulkan.model.image.impl.ImageFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Sampler Info</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Sampler Info</em>'.
	 * @generated
	 */
	SamplerInfo createSamplerInfo();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	ImagePackage getImagePackage();

} //ImageFactory
