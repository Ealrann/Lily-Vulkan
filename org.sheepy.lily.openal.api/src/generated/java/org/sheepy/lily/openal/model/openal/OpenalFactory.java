/**
 */
package org.sheepy.lily.openal.model.openal;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.sheepy.lily.openal.model.openal.OpenalPackage
 * @generated
 */
public interface OpenalFactory extends EFactory
{
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	OpenalFactory eINSTANCE = org.sheepy.lily.openal.model.openal.impl.OpenalFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Open AL Engine</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Open AL Engine</em>'.
	 * @generated
	 */
	OpenALEngine createOpenALEngine();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	OpenalPackage getOpenalPackage();

} //OpenalFactory
