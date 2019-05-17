/**
 */
package org.sheepy.vulkan.model.pipeline;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.sheepy.vulkan.model.pipeline.PipelinePackage
 * @generated
 */
public interface PipelineFactory extends EFactory
{
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	PipelineFactory eINSTANCE = org.sheepy.vulkan.model.pipeline.impl.PipelineFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Push Constant Range</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Push Constant Range</em>'.
	 * @generated
	 */
	PushConstantRange createPushConstantRange();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	PipelinePackage getPipelinePackage();

} //PipelineFactory
